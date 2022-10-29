package fa.training.services;

import java.util.List;

import fa.training.entities.Content;

public interface IContentService {
	List<Content> findAllByUser(String userName);

	boolean saveContent(Content content);
}
