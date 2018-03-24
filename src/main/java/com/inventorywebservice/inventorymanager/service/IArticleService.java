package com.inventorywebservice.inventorymanager.service;

import java.util.List;
import com.inventorywebservice.inventorymanager.model.Article;

public interface IArticleService {
     List<Article> getAllArticles();
     Article getArticleById(long articleId);
     boolean addArticle(Article article);
     void updateArticle(Article article);
     void deleteArticle(int articleId);
}
