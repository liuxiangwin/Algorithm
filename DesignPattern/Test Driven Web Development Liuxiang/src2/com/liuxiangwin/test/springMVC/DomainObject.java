package com.liuxiangwin.test.springMVC;

import java.util.Date;



public class DomainObject {
	private double _softCount;

	private double _hardCount;

	private Date _dropDate;

	public DomainObject(double softCount, double hardCount, Date dropDate) {
		this._softCount = softCount;
		this._hardCount = hardCount;
		this._dropDate = dropDate;

	}
   public DomainObject()
   {}
	public double get_softCount() {
		return _softCount;
	}

	public void set_softCount(double softCount) {
		_softCount = softCount;
	}

	public double get_hardCount() {
		return _hardCount;
	}

	public void set_hardCount(double hardCount) {
		_hardCount = hardCount;
	}

	public Date get_dropDate() {
		return _dropDate;
	}

	public void set_dropDate(Date dropDate) {
		_dropDate = dropDate;
	}
	
	  @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (!obj.getClass().equals(getClass())) {
	            return false;
	        }
	        DomainObject other = (DomainObject) obj;
	        return _softCount==other.get_softCount()
	                && _hardCount==(other.get_hardCount())
	                &&_dropDate.equals(other.get_dropDate());
	    }

}
