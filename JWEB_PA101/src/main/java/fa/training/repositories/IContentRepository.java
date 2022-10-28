package fa.training.repositories;

import java.util.List;

import fa.training.entities.Content;

public interface IContentRepository {
	List<Content> findAll();
	boolean saveContent(Content content1);
}
