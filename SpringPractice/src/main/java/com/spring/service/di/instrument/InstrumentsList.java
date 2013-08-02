package com.spring.service.di.instrument;

import java.util.List;

import com.spring.dao.di.instrument.Instrument;

public class InstrumentsList implements Performer {

	private String song;
	private Instrument instrument;
	private List<Instrument> instruments;
	
	public List<Instrument> getInstruments() {
		return instruments;
	}
	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
	}
	public Instrument getInstrument() {
		return instrument;
	}
	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}
	public String getSong() {
		return song;
	}
	public void setSong(String song) {
		this.song = song;
	}
	
	@Override
	public void perform() {
		// TODO Auto-generated method stub
		System.out.println("Playing " + song);
		instrument.play();
	}
	
	@Override
	public void performAll() {
		
		for(Instrument instrument : instruments){
			instrument.play();
		}
	}

}
