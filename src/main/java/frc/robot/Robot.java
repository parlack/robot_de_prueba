package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



public class Robot extends TimedRobot {


  //Intake
  int motorintakeport=6;

  Victor motorintake = new Victor(motorintakeport);

  int sole11=0;
  int sole12=1;



DoubleSolenoid pistonintk = new DoubleSolenoid(sole11, sole12);



  //TODO PA LOS MOTORES del chasis
  int chasmotizqport1=0;
  int chasmotizqport2=1;
  int chasmotizqport3=2;


  int chasmotderport4=3;
  int chasmotderport5=4;
  int chasmotderport6=5;


 
  WPI_TalonSRX motchasizq1 = new WPI_TalonSRX(chasmotizqport1);
  WPI_TalonSRX motchasizq2 = new WPI_TalonSRX(chasmotizqport2);
  WPI_TalonSRX motchasizq3 = new WPI_TalonSRX(chasmotizqport3);

  WPI_TalonSRX motchasder4 = new WPI_TalonSRX(chasmotderport4);
  WPI_TalonSRX motchasder5 = new WPI_TalonSRX(chasmotderport5);
  WPI_TalonSRX motchasder6 = new WPI_TalonSRX(chasmotderport6);


  SpeedControllerGroup motsI = new SpeedControllerGroup(motchasizq1, motchasizq2, motchasizq3);
  SpeedControllerGroup motsD= new SpeedControllerGroup(motchasder4, motchasder5, motchasder6);

  DifferentialDrive chass1= new DifferentialDrive(motsI, motsD);  

  //compresor

  Compressor compr = new Compressor();



  @Override
  public void robotInit() {}

  @Override
  public void robotPeriodic() {

  compr.setClosedLoopControl(true);


  }

  @Override
  public void autonomousInit() {



  }

  @Override
  public void autonomousPeriodic() {


    chass1.arcadeDrive(0.25, 0);



    

  }

  @Override
  public void teleopInit() {




  }

  @Override
  public void teleopPeriodic() {




  }

  @Override
  public void disabledInit(


  ) {}

  @Override
  public void disabledPeriodic() {

    pistonintk.set(Value.kOff);
    chass1.arcadeDrive(0, 0);
    compr.setClosedLoopControl(false);


  }

  @Override
  public void testInit() {




  }

  @Override
  public void testPeriodic() {




  }
}
