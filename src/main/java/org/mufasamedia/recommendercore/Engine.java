package org.mufasamedia.recommendercore;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.PearsonCorrelationSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;

public class Engine {

	public static String getRecommendation() {
		return "test";
	}

	public static List<String> getRecommendationList(int userId) {
		ArrayList<String> result = new ArrayList<String>();
		try {

			DataModel model = new FileDataModel(
					new File("/Users/dw/Documents/workspace/mufasamedia-recommendercore/intro.csv"));
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

			Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

			List<RecommendedItem> recommendations = recommender.recommend(userId, 3);

			for (RecommendedItem recommendation : recommendations) {
				result.add(recommendation.toString());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public static String testFunc() {

		String returnStr = "";

		try {

			DataModel model = new FileDataModel(
					new File("/Users/dw/Documents/workspace/mufasamedia-recommendercore/intro.csv"));
			UserSimilarity similarity = new PearsonCorrelationSimilarity(model);
			UserNeighborhood neighborhood = new NearestNUserNeighborhood(2, similarity, model);

			Recommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);

			List<RecommendedItem> recommendations = recommender.recommend(1, 1);

			for (RecommendedItem recommendation : recommendations) {
				returnStr += recommendation;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnStr;

	}

}
