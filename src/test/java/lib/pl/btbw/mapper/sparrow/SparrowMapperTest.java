package lib.pl.btbw.mapper.sparrow;

import entities.Article;
import entities.Category;
import entities.Section;
import entities.SubCategory;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class SparrowMapperTest {

	@Test
	public void mapper() {

		Article article = getArticle();

		SparrowMapper sparrowMapper = new SparrowMapper();
		Map<String, Object> stringObjectMap = sparrowMapper.asMap(article);

		assertThatArticle(stringObjectMap);
		assertCategory(stringObjectMap);
		assertSubCategory(stringObjectMap);
		assertListSections(stringObjectMap);
	}

	private void assertThatArticle(Map<String, Object> stringObjectMap) {

		assertThat(stringObjectMap.get("TITLE")).isEqualTo("Lorem ipsum");
		assertThat(stringObjectMap.get("TYPE")).isEqualTo(1);
	}

	private void assertCategory(Map<String, Object> stringObjectMap) {

		Map<String, Object> category = (Map<String, Object>) stringObjectMap.get("CATEGORY");
		assertThat(category.get("NAME")).isEqualTo("CARs");
	}

	private void assertSubCategory(Map<String, Object> stringObjectMap) {

		Map<String, Object> category = (Map<String, Object>) stringObjectMap.get("CATEGORY");
		Map<String, Object> subCategory = (Map<String, Object>) category.get("SUB_CATEGORY");
		assertThat(subCategory.get("NAME")).isEqualTo("Black");
	}

	private void assertListSections(Map<String, Object> stringObjectMap) {

		List<Map<String, Object>> sections = (List<Map<String, Object>>) stringObjectMap.get("SECTIONS");

		Map<String, Object> sectionA = sections.get(0);
		assertThat(sectionA.get("TITLE")).isEqualTo("Section 1");

		Map<String, Object> sectionB = sections.get(1);
		assertThat(sectionB.get("TITLE")).isEqualTo("Section 2");

		Map<String, Object> sectionC = sections.get(2);
		assertThat(sectionC.get("TITLE")).isEqualTo("Section 3");
	}

	private Article getArticle() {

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
		return article;
	}
}