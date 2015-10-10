package pl.ene.testwebapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.UserTransaction;

import pl.ene.testwebapp.domain.TestEntity;

public class TestServlet extends HttpServlet {
	
	@Resource
	//(mappedName = "java:comp/UserTransaction")
	private UserTransaction ut;
	
	
	@PersistenceUnit(unitName = "testPU" )
	private EntityManagerFactory entityManagerFactory;


	
	/**
   * 
   */
	private static final long serialVersionUID = 3384305172406736046L;

//	@Override
//	public void init() throws ServletException {
//
//		// TODO Auto-generated method stub
//		entityManagerFactory = Persistence
//				.createEntityManagerFactory("testPU");;
//		super.init();
//	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		try {
			
			PrintWriter writer = resp.getWriter();
			
//			InitialContext ctx = new InitialContext();
//			UserTransaction ut = (UserTransaction)ctx.lookup("java:comp/UserTransaction");
//			
			if (ut == null) {
				writer.println("User transaction is null");
				return;
			}
			
			if (entityManagerFactory == null) {
				writer.println("Factory is null");
				return;
			}
			
			//start transaction
			
			ut.begin();
		
			writer.println("Transaction status = " + ut.getStatus());
			EntityManager em = entityManagerFactory.createEntityManager();
			if (em == null) {
				writer.println("EntityManager is null");
				return;
			}
			writer.println("EntityManager created");
//			writer.println("Transaction created");
//			EntityTransaction tx =  em.getTransaction();
//			tx.begin();
			
			em.joinTransaction();
			TestEntity lvTestEntity = null;
			
			//list all
			writer.println("List all entity");
			List<TestEntity> list = em.createQuery("from TestEntity").getResultList();
			int i=1;
			for ( TestEntity e : list)
			{
				writer.println("ID ="  +  e.getId()+ " object = " + e.getObject());
				lvTestEntity = e;
			}	
			
			
			// criteria
//			try {
//				CriteriaBuilder qb = em.getCriteriaBuilder();
//				CriteriaQuery<TestEntity> c = qb.createQuery(TestEntity.class);
//				Root<TestEntity> p = c.from(TestEntity.class);
//				Predicate condition = qb.equal(p.get("id"), 1);
//				c.where(condition);
//				TypedQuery<TestEntity> q = em.createQuery(c);
//				lvTestEntity = q.getSingleResult();
//			} catch (NoResultException e) {
//				writer.println("No found entity");
//			}

			if (list.size() == 0) {
				writer.println("Create entity");
				lvTestEntity = new TestEntity();
				lvTestEntity.setId(1);
				lvTestEntity.setCode("1");
				lvTestEntity.setObject("First Entity");
				em.persist(lvTestEntity);
			}
			
			writer.println(" Test entity description = "
					+ lvTestEntity.getObject());
			writer.println("Transaction status = " + ut.getStatus());
//			tx.commit();
			writer.println(" EM flush ");
			em.flush();
			writer.println("commit");
			
			ut.commit();
			
			writer.println("Transaction status = " + ut.getStatus());
			writer.println(" EM close ");
			em.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			
		}
	}
}
