
jboss like module:
./jboss-cli.sh

module add --name=org.postgres --resources=/tmp/postgresql-9.3-1101.jdbc41.jar --dependencies=javax.api,javax.transaction.api

connect 

/subsystem=datasources/jdbc-driver=postgres:add(driver-name="postgres",driver-module-name="org.postgres",driver-class-name=org.postgresql.Driver)


uncomment <!--property name="hibernate.hbm2ddl.auto" value="create" -->

insert into uuser values (1,'ene','ene', 'ene@ene.pl', 'ene')
