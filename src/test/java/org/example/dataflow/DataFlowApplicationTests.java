package org.example.dataflow;

import org.apache.commons.lang3.StringUtils;
import org.junit.experimental.runners.Enclosed;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.countMatches;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(Enclosed.class)
@SpringBootTest
class DataFlowApplicationTests {

    public class Dinglemouse {
        public static int[] humanYearsCatYearsDogYears(final int humanYears) {
            int catYears, dogYears;

            if (humanYears == 1) {
                catYears = 15;
                dogYears = 15;
            } else if (humanYears == 2) {
                catYears = 15 + 9;
                dogYears = 15 + 9;
            } else {
                catYears = 15 + 9 + (humanYears - 2) * 4;
                dogYears = 15 + 9 + (humanYears - 2) * 5;
            }

            return new int[]{humanYears, catYears, dogYears};
        }
    }

//    public class Dinglemouse {
//        public static int[] humanYearsCatYearsDogYears(final int humanYears) {
//            int catYears = (humanYears == 1) ? 15 : (humanYears == 2) ? 24 : 24 + (humanYears - 2) * 4;
//            int dogYears = (humanYears == 1) ? 15 : (humanYears == 2) ? 24 : 24 + (humanYears - 2) * 5;
//            return new int[]{humanYears, catYears, dogYears};
//        }
//    }

//    Верните их возраст сейчас как [ humanYears, catYears, dogYears]
//    Кошачьи годы
//        15кошачьи годы для первого года
//        +9кошачьи годы для второго года
//        +4cat years за каждый последующий год
//     Годы Собаки
//        15собачьи годы для первого года
//        +9собачьи годы для второго года
//        +5собачьи годы за каждый последующий год


    @Nested
    public class ExampleTest {

        @Test
        public void one() {
            assertArrayEquals(new int[]{1, 15, 15}, Dinglemouse.humanYearsCatYearsDogYears(1));
        }

        @Test
        public void two() {
            assertArrayEquals(new int[]{2, 24, 24}, Dinglemouse.humanYearsCatYearsDogYears(2));
        }

        @Test
        public void ten() {
            assertArrayEquals(new int[]{10, 56, 64}, Dinglemouse.humanYearsCatYearsDogYears(10));
        }

    }

}



