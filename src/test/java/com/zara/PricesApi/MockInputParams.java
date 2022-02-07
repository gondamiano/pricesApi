package com.zara.PricesApi;

public class MockInputParams {

    public static InputMock getTenAmOnDayFourteenInput() {
        return new InputMock("2020-06-14T10:00:00", "1", "35455");
    }

    public static InputMock getFourPmOnDayFourteenInput() {
        return new InputMock("2020-06-14T16:00:00", "1", "35455");
    }

    public static InputMock getNinePmOnDayFourteenInput() {
        return new InputMock("2020-06-14T21:00:00", "1", "35455");
    }

    public static InputMock getTenAmOnDayFifteenInput() {
        return new InputMock("2020-06-14T21:00:00", "1", "35455");
    }

    public static InputMock getNinePmOnDaySixteenInput() {
        return new InputMock("2020-06-14T21:00:00", "1", "35455");
    }
}
