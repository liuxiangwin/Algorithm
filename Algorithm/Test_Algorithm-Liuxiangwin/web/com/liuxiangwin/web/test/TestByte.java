package com.liuxiangwin.web.test;

import java.util.HashMap;

public class TestByte {
	public static void main(String args[]) {
		HashMap<String,Hunman> hashmap= new HashMap<String,Hunman>();
		Hunman hunman1=new Hunman("Alan", "Beijing");
		Hunman hunman2=new Hunman("Alan", "ShangHai");
		
		
		hashmap.put("Alan", hunman2);
		hashmap.put("Alan", hunman1);
		
		for(String key:hashmap.keySet())
		{
			System.out.println(((Hunman)hashmap.get(key)).getDesc());
		}

		System.out.println((byte) 'C');

		System.out.println((byte) 'n');
		System.out.println((byte) 'n');

	}
}

class Hunman {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	private String desc;

	public Hunman(String name, String desc) {
		this.name = name;
		this.desc = desc;

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hunman other = (Hunman) obj;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}