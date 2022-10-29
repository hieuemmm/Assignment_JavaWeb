package fa.training.services;

import java.util.List;

import fa.training.entities.Content;
import fa.training.repositories.IContentRepository;
import fa.training.repositories.ContentRepository_Impl;

public class ContentService_Impl implements IContentService {
	IContentRepository contentRepository = new ContentRepository_Impl();

	@Override
	public List<Content> findAllByUser(String userName) {
		return contentRepository.findAllByUser(userName);
	}

	@Override
	public boolean saveContent(Content content) {
		return contentRepository.saveContent(content);
	}
}
