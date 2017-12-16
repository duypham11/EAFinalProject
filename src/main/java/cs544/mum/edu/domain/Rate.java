package cs544.mum.edu.domain;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rate {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	int count;
	float rate;
	
	public Rate() {
		count = 0;
		rate = 0.0f;
	}
	public Rate(int count, float rate) {
		this.count = count;
		this.rate = rate;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getRate() {
		return rate;
	}
	//rate: 0-10
	public float rate(int rate) {		
		this.rate = ((this.rate * count) + rate)/(count+1);
		count++;
		return this.rate;		
	}
	public void setRate(float rate) {
		this.rate = rate;
	}
}
