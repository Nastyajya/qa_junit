package guru.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class CatalogTest {
    static Stream<Arguments> catalogListTest() {
        return Stream.of(
                Arguments.of("Мужчинам", List.of("Идеи", "Новинки", "Одежда", "Обувь", "Аксессуары",
                        "Бренды", "Premium", "Спорт","Resale", "Красота", "Дом", "Sale%")),
                Arguments.of("Детям", List.of("Школа", "Новинки", "Девочкам", "Мальчикам",
                        "Малышам", "Бренды", "Premium", "Спорт", "Игрушки", "Дом", "Уход", "Resale", "Sale%"))
        );
    }

    @MethodSource
    @ParameterizedTest (name = "соответсвие списка каталога заданной категории {0}" )
    void catalogListTest(String catalogName, List<String> expectedButton) {
        open("https://www.lamoda.ru/");
        $$("._root_f9xmk_2").find(text(catalogName)).click();
        $$("._root_1416b_2 a").filter(visible).should(texts(expectedButton));
    }
}