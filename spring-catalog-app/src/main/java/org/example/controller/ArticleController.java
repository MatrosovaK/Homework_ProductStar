
package org.example.controller;

import org.example.model.Article;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ArticleController {

    private static final List<Article> articles = List.of(
            new Article(1L,
                    "Искусственный интеллект в медицине",
                    "Матросова Е.А., Бобров А.В., Бинди Л.",
                    2024),

            new Article(2L,
                    "Машинное обучение и анализ данных",
                    "Иванов И.И., Петров И.С.",
                    2023),

            new Article(3L,
                    "Нейронные сети: современные подходы",
                    "Петров И.С., Сидоров П.П., Иванова Н.В.",
                    2025),

            new Article(4L,
                    "Большие данные в научных исследованиях",
                    "Бинди Л., Матросова Е.А.",
                    2022),

            new Article(5L,
                    "Перспективы развития компьютерных технологий",
                    "Петров И.С., Сидоров С.С.",
                    2024)
    );

    @GetMapping("/")
    public String showArticles(Model model) {
        model.addAttribute("articles", articles);
        return "articles";
    }
}
