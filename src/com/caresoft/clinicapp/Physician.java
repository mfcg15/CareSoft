package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class Physician extends Usuario implements UsuarioCompatibleConHIPAA
{

	private ArrayList<String> patientNotes;
	
	public Physician(Integer id) 
	{
		super(id);
	}

	@Override
	public boolean assignPin(int pin) 
	{
		if(pin>999 || pin<10000)
		{
			return true;
		}
		
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) 
	{
		int identificacion = getId();
		
		if(identificacion==confirmedAuthID)
		{
			return true;
		}
		
		return false;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) 
	{
        String report = String.format(
            "Fecha y hora de envío: %s \n", date);
        report += String.format("Reportado por ID: %s\n", this.id);
        report += String.format("Nombre del paciente: %s\n", patientName);
        report += String.format("Notas: %s \n", notes);
        this.patientNotes.add(report);
    }
	
	public ArrayList<String> getPatientNotes() 
	{
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) 
	{
		this.patientNotes = patientNotes;
	}

}
