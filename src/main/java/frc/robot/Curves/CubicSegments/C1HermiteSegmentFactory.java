package frc.robot.Curves.CubicSegments;

import edu.wpi.first.math.geometry.Translation2d;
import frc.robot.Curves.SplineSegment;
import frc.robot.Curves.SplineSegmentFactory;

public class C1HermiteSegmentFactory extends SplineSegmentFactory {
  public Translation2d V0;
  public Translation2d P1;
  public Translation2d V1;

  /**
   * Takes in the final three control points. The first control point
   * is extrapolated from the previous segment. @author :3
   */
  public C1HermiteSegmentFactory(Translation2d V0,
      Translation2d P1,
      Translation2d V1) {
    this.V0 = V0;
    this.P1 = P1;
    this.V1 = V1;
  }

  @Override
  public SplineSegment build(SplineSegment previousSegment) {
    if (previousSegment == null)
      throw new UnsupportedOperationException("C1Continuous Bezier Factory cannot be first segment");
    
    Translation2d P0 = previousSegment.sample(1);
    return new BezierSegment(P0, P0.plus(V0.div(3)), P1.minus(V1.div(3)), P1);
  }
}
