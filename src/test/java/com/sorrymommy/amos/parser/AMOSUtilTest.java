package com.sorrymommy.amos.parser;

import com.sorrymommy.amos.AMOSUtil;
import com.sorrymommy.amos.model.normal.MetarItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AMOSUtilTest {
    @Test
    public void test(){
        MetarItem item = AMOSUtil.getInstance().Normal.Metar.getValue ("RKSI");

        Assertions.assertTrue("RKSI".equals(item.getIcaoCode()));
        Assertions.assertTrue("인천공항".equals(item.getAirportName()));
        Assertions.assertTrue(!item.getMetarMsg().isEmpty());
    }
}
