package entity;

import java.util.List;

/**
 * Created by Blong on 2018/3/19.
 */
public class ModelOneData {
    private List<StackBarEntity> stackBarEntityList;
    private List<POIDrawTableEntity> poiDrawTableEntityList;
    private List<ScatterEntity> scatterEntityList;
    private List<String> contentList;
    private List<SingleBarEntity> singleBarEntityList;
    private List<MultiBarEntity> multiBarEntityList;
    private List<MultiStackBarEntity> multiStackBarEntityList;
    private List<DualAxisChartEntity> dualAxisChartEntityList;
    public ModelOneData() {
    }

    public ModelOneData(List<String> contentList,List<StackBarEntity> stackBarEntityList, List<POIDrawTableEntity> poiDrawTableEntityList, List<ScatterEntity> scatterEntityList) {
        this.stackBarEntityList = stackBarEntityList;
        this.poiDrawTableEntityList = poiDrawTableEntityList;
        this.scatterEntityList = scatterEntityList;
        this.contentList = contentList;
    }

    public List<String> getContentList() {
        return contentList;
    }

    public void setContentList(List<String> contentList) {
        this.contentList = contentList;
    }

    public List<StackBarEntity> getStackBarEntityList() {
        return stackBarEntityList;
    }

    public void setStackBarEntityList(List<StackBarEntity> stackBarEntityList) {
        this.stackBarEntityList = stackBarEntityList;
    }

    public List<POIDrawTableEntity> getPoiDrawTableEntityList() {
        return poiDrawTableEntityList;
    }

    public void setPoiDrawTableEntityList(List<POIDrawTableEntity> poiDrawTableEntityList) {
        this.poiDrawTableEntityList = poiDrawTableEntityList;
    }

    public List<ScatterEntity> getScatterEntityList() {
        return scatterEntityList;
    }

    public void setScatterEntityList(List<ScatterEntity> scatterEntityList) {
        this.scatterEntityList = scatterEntityList;
    }

    public List<SingleBarEntity> getSingleBarEntityList() {
        return singleBarEntityList;
    }

    public void setSingleBarEntityList(List<SingleBarEntity> singleBarEntityList) {
        this.singleBarEntityList = singleBarEntityList;
    }

    public List<MultiBarEntity> getMultiBarEntityList() {
        return multiBarEntityList;
    }

    public void setMultiBarEntityList(List<MultiBarEntity> multiBarEntityList) {
        this.multiBarEntityList = multiBarEntityList;
    }

    public List<MultiStackBarEntity> getMultiStackBarEntityList() {
        return multiStackBarEntityList;
    }

    public void setMultiStackBarEntityList(List<MultiStackBarEntity> multiStackBarEntityList) {
        this.multiStackBarEntityList = multiStackBarEntityList;
    }

    public List<DualAxisChartEntity> getDualAxisChartEntityList() {
        return dualAxisChartEntityList;
    }

    public void setDualAxisChartEntityList(List<DualAxisChartEntity> dualAxisChartEntityList) {
        this.dualAxisChartEntityList = dualAxisChartEntityList;
    }

    @Override
    public String toString() {
        return "ModelOneData{" +
                "stackBarEntityList=" + stackBarEntityList +
                ", poiDrawTableEntityList=" + poiDrawTableEntityList +
                ", scatterEntityList=" + scatterEntityList +
                ", contentList=" + contentList +
                ", singleBarEntityList=" + singleBarEntityList +
                ", multiBarEntityList=" + multiBarEntityList +
                ", multiStackBarEntityList=" + multiStackBarEntityList +
                ", dualAxisChartEntityList=" + dualAxisChartEntityList +
                '}';
    }
}

