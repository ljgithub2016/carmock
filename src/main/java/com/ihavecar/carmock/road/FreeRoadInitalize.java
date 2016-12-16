package com.ihavecar.carmock.road;

import com.google.common.collect.Lists;
import com.ihavecar.carmock.entity.Point;
import com.ihavecar.carmock.entity.Road;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import static com.ihavecar.carmock.config.Global.getString;
import static com.ihavecar.carmock.entity.Constants.ROAD_FREEPATH;

/**
 * Created by lsz on 2016/12/5.
 */
public class FreeRoadInitalize implements RoadInitalize {
    private Long lock = new Long(1);
    private List<Point[]> pointsResource = null;
    private void checkResource(){
        if(pointsResource == null){
            synchronized (lock){
                if(pointsResource == null){
                    pointsResource = Lists.newArrayList();
                    try {
                        pointsResource.addAll(initFromDir(getString(ROAD_FREEPATH)));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public Road load() {
        checkResource();
        Road road = new Road(get());

        return road;
    }
    public Point[] get(){
        int len = pointsResource.size();
        int inx = (int) (len*Math.random());
        inx = inx == len ? inx-1:inx;

        return pointsResource.get(inx);
    }

    private List<Point[]> initFromDir(String path) throws IOException {
        List<Point[]> results = Lists.newArrayList();
        File dir = new File(path);
        File[] files = dir.listFiles(x->x.getName().contains(".txt"));
        for (File file:files){
            List<Point> points = Files.lines(file.toPath(), Charset.defaultCharset())
                .map(line->line.split(","))
                .map(ss->new Point(Double.valueOf(ss[1]),Double.valueOf(ss[0])))
                .collect(Collectors.toList()) ;
            if (points.size() == 0)continue;
            final int size = points.size();
            Point[] arr = (Point[])points.toArray(new Point[size]);
            results.add(arr);
        }
        return results;
    }
}
