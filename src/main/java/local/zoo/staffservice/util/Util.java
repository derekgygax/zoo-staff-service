package local.zoo.staffservice.util;

import java.time.LocalDate;

import local.zoo.staffservice.dto.staff.StaffBase;
import local.zoo.staffservice.enums.Title;

public class Util {

    public static StaffBase getFakeStaffBase() {
        StaffBase fakeStaffBase = new StaffBase(
                "John",
                "Doe",
                Title.ZOOKEEPER,
                "john.doe@example.com",
                "+1234567890",
                LocalDate.of(2020, 1, 1),
                LocalDate.of(2020, 1, 15));
        return fakeStaffBase;
    }

}
