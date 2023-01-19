package com.incedo.streams;

import java.util.ArrayList;
import java.util.List;

public class StreamsTest {

		public static void main(String[] args) {
			
			List<Book> books = new ArrayList<>();
			
			books.addAll(DataExtractor.getFromAmazon("java"));
			books.addAll(DataExtractor.getFromBarnesAndNoble("java"));
			

		}

	

}
