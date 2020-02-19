package ConsumerLab;

import java.io.File;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		
		System.out.println("test:: " + Review.sentimentVal("test"));
		System.out.println("potatoes:: " + Review.sentimentVal("potatoes"));
		System.out.println("epic:: " + Review.sentimentVal("epic"));
		System.out.println("Total Sentiment:: " + Review.totalSentiment("src/ConsumerLab/26WestReview.txt"));
		System.out.println("Star Rating:: " + Review.starRating("src/ConsumerLab/26WestReview.txt"));
		System.out.println("Total Sentiment:: " + Review.totalSentiment("src/ConsumerLab/simpleReview.txt"));
		System.out.println("Star Rating:: " + Review.starRating("src/ConsumerLab/simpleReview.txt"));
		System.out.println("Old Review:: " + Review.textToString("src/ConsumerLab/simpleReview.txt"));
		System.out.println("New Review:: " + Review.fakeReview("src/ConsumerLab/simpleReview.txt"));
		// test reading from files
		// read in the positive adjectives in postiveAdjectives.txt
		try {
			Scanner input = new Scanner(new File("src/ConsumerLab/positiveAdjectives.txt"));
			
			while (input.hasNextLine()) {
				String temp = input.nextLine().trim();
				//System.out.println(temp);

			}
			
			input.close();
			
		} catch (Exception e) {
			System.out.println("Error reading or parsing postitiveAdjectives.txt\n" + e);
		}
	}
}