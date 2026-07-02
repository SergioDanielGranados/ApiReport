package org.report.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.report.dto.ItemSearch;

public class UserTest {


    @Test
    public void userTest(){

      ItemSearch s = new ItemSearch();
      s.setSearch("a");
      s.getSearch();
      Assertions.assertNotNull(s);

    }
}
