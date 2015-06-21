import entities.Article;
import entities.Category;
import entities.Section;
import entities.SubCategory;
import lib.pl.btbw.mapper.SparrowMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {

	public static void main(String[] args) {

		List<Section> sectionList = new ArrayList<>();
		sectionList.add(new Section("Section 1"));
		sectionList.add(new Section("Section 2"));
		sectionList.add(new Section("Section 3"));

		SubCategory subCategory = new SubCategory();
		subCategory.setName("Black");

		Category category = new Category();
		category.setName("CARs");
		category.setSubCategory(subCategory);

		Article article = new Article();
		article.setTitle("Lorem ipsum");
		article.setType(1);
		article.setCategory(category);
		article.setSections(sectionList);

		SparrowMapper sparrowMapper = new SparrowMapper();
		Map<String, Object> stringObjectMap = sparrowMapper.asMap(article);

		System.out.println(stringObjectMap);


	}

}