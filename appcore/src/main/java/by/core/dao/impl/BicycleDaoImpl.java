package by.core.dao.impl;

import by.core.catalogs.BicycleClass;
import by.core.catalogs.Materials;
import by.core.dao.BicycleDAO;
import by.core.models.BicycleModel;

import javax.sql.DataSource;
import java.sql.*;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Denis on 09.07.2016.
 */

public class BicycleDaoImpl implements BicycleDAO {

    private DataSource dataSource;

    public void saveBicycle(BicycleModel bicycleModel) {
        final String SQL_SAVE_NEW_EVENT = "INSERT INTO BICYCLE (bicycle_id, producerName, wheelQuantity, wheelSize, releaseYear, bicycleClass, frameMaterials) VALUES (?,?,?,?,?,?,?)";
        HashMap<Integer, Object> map = new HashMap<Integer, Object>();
        map.put(1, bicycleModel.getBicycle_id());
        map.put(2, bicycleModel.getProducerName());
        map.put(3, bicycleModel.getWheelQuantity());
        map.put(4, bicycleModel.getWheelSize());
        map.put(5, bicycleModel.getReleaseYear());
        map.put(6, bicycleModel.getBicycleClass());
        map.put(7, bicycleModel.getFrameMaterials());
        executeQuery(SQL_SAVE_NEW_EVENT, map);
    }

    //TODO
    public void updateBicycle(BicycleModel bicycleModel) {

    }


    public BicycleModel getBicycle(int bicycle_id) {
        final String SQL_SEARCH_BICYCLE_BY_ID = "SELECT * FROM BICYCLE WHERE bicycle_id = ?";

        //TODO need refactoring - move this code to Utils.java
        Connection connection = null;
        BicycleModel bicycleModel = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL_SEARCH_BICYCLE_BY_ID);
            ps.setInt(1, bicycle_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                bicycleModel = new BicycleModel(
                        rs.getInt("bicycle_id"),
                        rs.getString("producerName"),
                        rs.getInt("wheelQuantity"),
                        rs.getInt("wheelSize"),
                        rs.getInt("releaseYear"),
                        BicycleClass.valueOf(rs.getString("bicycleClass")),
                        Materials.valueOf(rs.getString("frameMaterials"))
                );
            }
            ps.close();
            if (bicycleModel != null){
                return bicycleModel;
            } else {
                System.out.println("Object with that parameters is not founded");
            }
        } catch (SQLException e) {
            System.out.println("FAIL: something wrong with connection or query");
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
        return bicycleModel;
    }

    public List<BicycleModel> getAllBicycles() {
        return null;
    }

    public void deleteBicycle(int id) {
        final String SQL_DELETE_BICYCLE = "DELETE FROM EVENT WHERE BICYCLE_ID = ?";
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(1, id);
        executeQuery(SQL_DELETE_BICYCLE, map);
    }


    private void executeQuery(String query, HashMap parameters){
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            for (int i = 1; i < parameters.size()+1; i++) {
                if(parameters.get(i) instanceof String){
                    ps.setString(i, String.valueOf(parameters.get(i)));
                } else if(parameters.get(i) instanceof Time){
                    ps.setTime(i, (Time) parameters.get(i));
                } else if(parameters.get(i) instanceof Date){
                    java.util.Date utilDate = (Date) parameters.get(i);
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    ps.setDate(i, sqlDate);
                } else if(parameters.get(i) instanceof java.util.Date){
                    java.sql.Date sqlDate = new java.sql.Date(((Date) parameters.get(i)).getTime());
                    ps.setDate(i, sqlDate);
                } else if(parameters.get(i) instanceof Integer){
                    ps.setInt(i, (Integer) parameters.get(i));
                } else if(parameters.get(i) instanceof Double){
                    ps.setDouble(i, (Double) parameters.get(i));
                }
            }
            ps.executeUpdate();
            ps.close();
            System.out.println("Action OK!");
        } catch (SQLException e) {
            System.out.println("FAIL: something wrong with connection or query");
            e.printStackTrace();
        } finally {
            closeConnection(connection);
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("FAIL: something wrong with closing connection");
            }
        }
    }

}
