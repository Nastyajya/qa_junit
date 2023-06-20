package guru.qa;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class RailwayTest extends TestBase {
    @CsvSource({
            "https://xn----btbhgbpv1d7d.xn--80aswg/skidka-pensioneram-ot-60-let-15-v-kupe-2023, в возрасте 60 лет и старше действует скидка 15%",
            "https://xn----btbhgbpv1d7d.xn--80aswg/skidka-50-na-zhd-bilety-detyam-10-17-let-na-letnie-kanikuly-2023, Скидка 50% на жд билеты в период летних каникул"
    })

    @DisplayName("Проверка корректной информации на странице скидки")
    @ParameterizedTest(name = "На странице url {0} должен отображаться текст {1}")
    void discountForPensioners(String url, String searchQuery) {
        open(url);
        $(".t030__descr").shouldHave(text(searchQuery));
    }
}




