package org.mufasamedia.recommendercoretest;
import org.mufasamedia.recommendercore.*;

public class UnitTest {
	
	public static void main( String args[] ) {
		
		int userID = 1;
		int recommendationCount = 2;
		
		for ( String item: Engine.getRecommendationList( userID, recommendationCount ) )
			System.out.println( item );
		
	}

}
