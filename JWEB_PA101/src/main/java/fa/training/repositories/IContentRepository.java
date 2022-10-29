package fa.training.repositories;

import java.util.List;

import fa.training.entities.Content;

public interface IContentRepository {
	List<Content> findAllByUser(String userName);
	boolean saveContent(Content content);
}
