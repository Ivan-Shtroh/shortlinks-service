package org.shtroh.shortlnkservice.service;

public interface LinkManageService {

    String getUrl(String request);

    String generateShortLink(String url);
}
