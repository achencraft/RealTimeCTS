package dev.spigot.RealTimeCTS;

public class json {

    public ServiceDelivery ServiceDelivery;
}

class ServiceDelivery{
    public StopMonitoringDelivery StopMonitoringDelivery[];
    public String ResponseTimestamp;
    public String RequestMessageRef;
}

class StopMonitoringDelivery{
    public MonitoredStopVisit MonitoredStopVisit[];
    public String version;
    public String ResponseTimeStamp;
    public String ValidUntil;
    public String ShortestPossibleCycle;
    public String MonitoringRef[];

}

class MonitoredStopVisit{
    public MonitoredVehicleJourney MonitoredVehicleJourney;
    public String RecordedAtTime;
    public String MonitoringRef;
    public String StopCode;

}

class MonitoredVehicleJourney{
    public String Lineref;
    public String DirectionRef;
    public FramedVehicleJourneyRef FramedVehicleJourneyRef;
    public String VehicleMode;
    public String PublishedLineName;
    public String DestinationName;
    public String DestinationShortName;
    public String Via;
    public String Bearing;
    public String Delay;
    public MonitoredCall MonitoredCall;
}

class FramedVehicleJourneyRef{
    public String DateVehicleJourneySAERef;
}

class MonitoredCall{
    public String StopPointName;
    public String ExpectedDepartureTime;
    public String ExpectedArrivalTime;
    public Extension Extension;
}

class Extension{
    public Boolean IsRealTime;
}