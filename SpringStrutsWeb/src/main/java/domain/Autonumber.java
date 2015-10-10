package domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author eneugebauer
 *
 *	create table autonumber
	(
	id integer not null primary key,
	key varchar not null,
	value varchar not null
	)
 */

@Entity
@Table(name = "autonumber")
public class Autonumber implements Serializable {
	private Integer id;
	private String key;
	private String value;

	public Autonumber() {

	}
	
	@Id
	@Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_autonumber")
    @SequenceGenerator(name="seq_autonumber", sequenceName="seq_autonumber")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
