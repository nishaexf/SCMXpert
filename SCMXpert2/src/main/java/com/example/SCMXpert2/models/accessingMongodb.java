package com.example.SCMXpert2.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="DeviceDataStream")
public class accessingMongodb {

	@Id
	private String id;
	
	private String Battery_Level;
	
	private String Route_From;
	
	private Integer Device_Id;
	
	private String Route_To;
	 
	private Float First_Sensor_temperature;

}
