package com.kcabs.service;

import java.util.List;

//org.springframework.beans.factory.annotation.Autowired(required=true);

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kcabs.dao.TripDao;
import com.kcabs.model.Trip;

@Service
@Component
public class TripServiceImpl implements TripService
{
	@Autowired
	TripDao tripDao;

	@Override
	public List<Trip> listAllTrips() {
		// TODO Auto-generated method stub
		return tripDao.listAllTrips();
	}

	@Override
	public void addTrip(Trip trip) {
		// TODO Auto-generated method stub
		tripDao.addTrip(trip);
	}

	@Override
	public void updateTrip(Trip trip) {
		// TODO Auto-generated method stub
		tripDao.updateTrip(trip);
		
	}

	@Override
	public void deleteTrip(Integer trip_id) {
		// TODO Auto-generated method stub
		tripDao.deleteTrip(trip_id);
		
	}

	@Override
	public List<Trip> findTripsByDrivNo(Integer driv_no) {
		// TODO Auto-generated method stub
		return tripDao.findTripsByDrivNo(driv_no);
	}

	@Override
	public Trip findTripByTripId(Integer trip_id) {
		// TODO Auto-generated method stub
		return tripDao.findTripByTripId(trip_id);
	}

	@Override
	public Integer rateTrips(Integer trip_id, Integer charges, Integer rating) {
		// TODO Auto-generated method stub
		return trip_id;
		
	}

	@Override
	public Trip findDrivIdByTripId(Integer trip_id) {
		// TODO Auto-generated method stub
		return tripDao.findDrivIdByTripId(trip_id);
	}
}
