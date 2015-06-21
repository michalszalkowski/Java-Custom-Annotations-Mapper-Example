package lib.pl.btbw.mapper.siskin;

import entities.Article;
import entities.Section;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.fest.assertions.Assertions.assertThat;

public class SiskinMapperTest {

	@Test
	public void mapper() {

		SiskinMapper siskinMapper = new SiskinMapper();

		Map<String, Object> map = getArticleMap();
		Article article = (Article) siskinMapper.asObj(map, new Article());

		assertThat(article.getTitle()).isEqualTo("Lorem Ipsum");
		assertThat(article.getType()).isEqualTo(2);

		assertThat(article.getCategory().getName()).isEqualTo("Dogs");
		assertThat(article.getCategory().getSubCategory().getName()).isEqualTo("White");

		List<Section> sections = article.getSections();
		assertThat(sections.get(0).getTitle()).isEqualTo("Ipsum A");
		assertThat(sections.get(1).getTitle()).isEqualTo("Ipsum B");
		assertThat(sections.get(2).getTitle()).isEqualTo("Ipsum C");
	}

	public Map<String, Object> getArticleMap() {
		Map<String, Object> article = getSections("Lorem Ipsum");
		article.put("TYPE", 2);

		List<Map<String, Object>> sections = new ArrayList<>();
		sections.add(getSections("Ipsum A"));
		sections.add(getSections("Ipsum B"));
		sections.add(getSections("Ipsum C"));

		article.put("SECTIONS", sections);

		Map<String, Object> category = new HashMap<>();
		category.put("NAME", "Dogs");

		Map<String, Object> subCategory = new HashMap<>();
		subCategory.put("NAME", "White");

		category.put("SUB_CATEGORY", subCategory);

		article.put("CATEGORY", category);

		return article;
	}


	public Map<String, Object> getSections(String value) {
		Map<String, Object> sections = new HashMap<>();
		sections.put("TITLE", value);
		return sections;
	}
}