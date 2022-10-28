package fa.training.services;

import java.util.List;

import fa.training.entities.Content;

public interface IContentService {
	List<Content> findAll();

	boolean saveContent(Content content1);
}
