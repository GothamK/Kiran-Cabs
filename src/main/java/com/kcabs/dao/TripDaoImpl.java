package com.kcabs.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import com.kcabs.model.Trip;


@Repository
public class TripDaoImpl implements TripDao{
	@Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	PaymentsDao pd;
    
	@Autowired
	public void setNameParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) 
{
	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate ;
}
	@Autowired
    JdbcTemplate jt;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) 
    {
        this.jt = jdbcTemplate;
    }
	
	 public List<Trip> listAllTrips() {
		  String sql = "SELECT * FROM trips";
		  
		  List<Trip> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new TripMapper());
		  
		  return list;
		 }	
	
	
	   private static final class TripMapper implements RowMapper<Trip>
	   {
		   public Trip mapRow(ResultSet rs,int rowNum) throws SQLException
		   {
			   Trip trip = new Trip();
			   trip.setTrip_id(rs.getInt("trip_id"));
			   trip.setCustomer_name(rs.getString("customer_name"));
			   trip.setDate(rs.getString("date"));
			   trip.setDist(rs.getFloat("dist"));
			   trip.setDuration(rs.getFloat("duration"));
			   trip.setCharges(rs.getInt("charges"));
			   trip.setRegistration_no(rs.getString("registration_no"));
			   trip.setDriv_no(rs.getInt("driv_no"));
			   trip.setPickup_point(rs.getString("pickup_point"));
			   trip.setDrop_point(rs.getString("drop_point"));
			   trip.setRating(rs.getInt("rating"));
			   trip.setPayment_id(rs.getInt("payment_id"));
			   
			   return trip;
			   
		   }
	   }
	   
	   private SqlParameterSource getSqlParameterByModel(Trip trip) {
			MapSqlParameterSource paramSource =new MapSqlParameterSource();
			   if(trip!= null)
			   {
				   paramSource.addValue("trip_id", trip.getTrip_id());
				   paramSource.addValue("customer_name", trip.getCustomer_name());
				   paramSource.addValue("date", trip.getDate());
				   paramSource.addValue("dist", trip.getDist());
				   paramSource.addValue("duration",trip.getDuration());
				   paramSource.addValue("charges",trip.getCharges());
				   paramSource.addValue("registration_no", trip.getRegistration_no());
				   paramSource.addValue("driv_no", trip.getDriv_no());
				   paramSource.addValue("pickup_point", trip.getPickup_point());
				   paramSource.addValue("drop_point", trip.getDrop_point());
				   paramSource.addValue("rating", trip.getRating());
				   paramSource.addValue("payment_id", trip.getPayment_id());
				   
			   }
			return paramSource;
		}
	
		@Override
		public void addTrip(Trip trip) {
			Integer payment_id = pd.add(trip.getCharges(), trip.getDate(), "Trip", "Kcabc");
			trip.setPayment_id(payment_id);
			String sql="INSERT INTO trips(customer_name,date,dist,duration,charges,registration_no,driv_no,pickup_point,drop_point,rating,payment_id) values(:customer_name,:date,:dist,:duration,:charges,:registration_no,:driv_no,:pickup_point,:drop_point,:rating,:payment_id)";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(trip));
		}	
		
		@Override
		public void updateTrip(Trip trip) {
			// 
			String sql="UPDATE trips set customer_name=:customer_name, date=:date,dist=:dist, duration=:duration, charges=:charges, registration_no=:registration_no, driv_no=:driv_no, pickup_point=:pickup_point, drop_point=:drop_point, rating=:rating where trip_id=:trip_id";
			jt.update(sql,getSqlParameterByModel(trip));
			 
		}

		@Override
		public void deleteTrip(Integer trip_id) {
			// 
			String sql="DELETE FROM trips WHERE trip_id=:trip_id";
			namedParameterJdbcTemplate.update(sql,getSqlParameterByModel(new Trip(trip_id)));
			
		}

		@Override
		public Trip findTripByTripId(Integer trip_id) {
			// TODO Auto-generated method stub
			String sql="SELECT * FROM trips WHERE trip_id=:trip_id";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Trip(trip_id)),new TripMapper() );
			
		}

		@Override
		public List<Trip> findTripsByDrivNo (Integer driv_no) {
			// TODO Auto-generated method stub
			String sql = "SELECT * FROM trips WHERE driv_no =: driv_no";
			 List<Trip> list = namedParameterJdbcTemplate.query(sql, getSqlParameterByModel(null), new TripMapper()  );
			return list;
		}
		@Override
		public Integer rateTrips(Integer trip_id,Integer charges, Integer rating)
		{
			System.out.println("jai ho sabki");
			String sql = "update trips set rating =? where trip_id=? and charges=?";
			jt.update(sql,new Object[] {rating,trip_id,charges});
			return trip_id;
		}
		
		@Override
		public Trip findDrivIdByTripId(Integer trip_id) {
			// TODO Auto-generated method stub
			String sql="SELECT driv_no FROM trips WHERE trip_id=:trip_id";
		return	namedParameterJdbcTemplate.queryForObject(sql, getSqlParameterByModel(new Trip(trip_id)),new TripMapper() );
		}
	
		

}
