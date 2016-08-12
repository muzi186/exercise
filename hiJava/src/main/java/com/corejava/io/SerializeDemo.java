package com.corejava.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeDemo {
	public byte[] serialize(Serializable obj) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(obj);
		oos.flush();
		
		
		return bos.toByteArray();
	}

	public Object deserialize(byte[] buf) throws IOException, ClassNotFoundException {
		ByteArrayInputStream bais = new ByteArrayInputStream(buf);
		ObjectInputStream ois = new ObjectInputStream(bais);
		
		Object obj = ois.readObject();
		return obj;
	}

	public static class Book implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 7450721789375296049L;
		private String name;
		private String author;

		public String getName() {
			return name;
		}

		public String getAuthor() {
			return author;
		}

		public Book(String name, String author) {
			super();
			this.name = name;
			this.author = author;
			
			System.out.println("Book(String,String)");
		}

	}

	public static void main(String... args) throws Exception{
		Book b1 = new Book("java与模式", "阎宏");
		SerializeDemo demo = new SerializeDemo();
		
		byte[] bytes = demo.serialize(b1);
		
		//Book ni = b1.getClass().newInstance();
		
		//System.out.println(ni);
/*		
		Book ni = null;
		Class<?> clazz = b1.getClass();
		Constructor<?> cons = clazz.getConstructor((Class[])null);
		if(cons == null){
			System.out.println("Cons is null.");
		}else{
			cons.setAccessible(true);
			ni = (Book) cons.newInstance(null);
		}
		
		System.out.println("NI:" + ni);
		*/
		
		System.out.println("Deserialize...");
		
		Book b2 = (Book) demo.deserialize(bytes);
		System.out.println(String.format("Book: %s %s", b2.getName(), b2.getAuthor()));
	}
}
