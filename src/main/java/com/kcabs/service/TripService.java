package com.kcabs.service;

import java.util.List;
import com.kcabs.model.Trip;

public interface TripService
{
	public List<Trip> listAllTrips();
	
	public void addTrip(Trip trip);
	
	public void updateTrip(Trip trip); 
	
	public void deleteTrip(Integer trip_id);
	
	public List<Trip> findTripsByDrivNo(Integer driv_no);
	
	public Trip findTripByTripId(Integer trip_id);

	public Integer rateTrips(Integer trip_id, Integer charges, Integer rating);
	
	public Trip findDrivIdByTripId(Integer trip_id);
	
}