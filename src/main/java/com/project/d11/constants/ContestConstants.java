package com.project.d11.constants;

import com.project.d11.models.dto.RankPrizeModel;

import java.util.ArrayList;
import java.util.List;

public class ContestConstants {
    public ContestConstants() {

    }

    public static List<RankPrizeModel> getContest29(){
        List<RankPrizeModel> rankPrizeList = new ArrayList<>();
        rankPrizeList.add(new RankPrizeModel("#1","50000"));
        rankPrizeList.add(new RankPrizeModel("#2","20000"));
        rankPrizeList.add(new RankPrizeModel("#3","12000"));
        rankPrizeList.add(new RankPrizeModel("#4 - 6 ","1200"));
        rankPrizeList.add(new RankPrizeModel("#7 - 120","29"));
        return rankPrizeList;
    }


    public static List<RankPrizeModel> getContest49(){
        List<RankPrizeModel> rankPrizeList = new ArrayList<>();
        rankPrizeList.add(new RankPrizeModel("#1","100000"));
        rankPrizeList.add(new RankPrizeModel("#2","45000"));
        rankPrizeList.add(new RankPrizeModel("#3","20000"));
        rankPrizeList.add(new RankPrizeModel("#4 - 6 ","5000"));
        rankPrizeList.add(new RankPrizeModel("#7 - 120","490"));
        return rankPrizeList;
    }


}
