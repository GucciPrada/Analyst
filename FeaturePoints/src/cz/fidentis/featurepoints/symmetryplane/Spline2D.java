package cz.fidentis.featurepoints.symmetryplane;

/*
 * @(#)Spline2D.java
 * 
 * Copyright (c) 2003 Martin Krueger
 * Copyright (c) 2005 David Benson
 *  
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.vecmath.Point2d;
import javax.vecmath.Point3d;

/**
 * Interpolates points given in the 2D plane. The resulting spline is a function
 * s: R -> R^2 with parameter t in [0,1].
 *
 * @author krueger
 */
public class Spline2D {

    /**
     * Array representing the relative proportion of the total distance of each
     * point in the line ( i.e. first point is 0.0, end point is 1.0, a point
     * halfway on line is 0.5 ).
     */
    private double[] t;
    private Spline splineX;
    private Spline splineY;
    /**
     * Total length tracing the points on the spline
     */
    private double length;

    /**
     * Creates a new Spline2D.
     *
     * @param points
     */
    public Spline2D(Point2d[] points) {
        double[] x = new double[points.length];
        double[] y = new double[points.length];

        for (int i = 0; i < points.length; i++) {
            x[i] = points[i].getX();
            y[i] = points[i].getY();
        }

        init(x, y);
    }

    /**
     * Creates a new Spline2D.
     *
     * @param points
     */
    public Spline2D(List<Point3d> points) {
        double[] x = new double[points.size()];
        double[] y = new double[points.size()];

        // pre ucely symetrickej roviny používam súradnice y a z
        for (int i = 0; i < points.size(); i++) {
            x[i] = points.get(i).getY();
            y[i] = points.get(i).getZ();
        }

        init(x, y);
    }

    /**
     * Creates a new Spline2D.
     *
     * @param x
     * @param y
     */
    public Spline2D(double[] x, double[] y) {
        init(x, y);
    }

    private void init(double[] x, double[] y) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("Arrays must have the same length.");
        }

        if (x.length < 2) {
            throw new IllegalArgumentException("Spline edges must have at least two points.");
        }

        t = new double[x.length];
        t[0] = 0.0; // start point is always 0.0

        // Calculate the partial proportions of each section between each set
        // of points and the total length of sum of all sections
        for (int i = 1; i < t.length; i++) {
            double lx = x[i] - x[i - 1];
            double ly = y[i] - y[i - 1];
            // If either diff is zero there is no point performing the square root
            if (0.0 == lx) {
                t[i] = Math.abs(ly);
            } else if (0.0 == ly) {
                t[i] = Math.abs(lx);
            } else {
                t[i] = Math.sqrt(lx * lx + ly * ly);
            }

            length += t[i];
            t[i] += t[i - 1];
        }

        for (int i = 1; i < (t.length) - 1; i++) {
            t[i] = t[i] / length;
        }

        t[(t.length) - 1] = 1.0; // end point is always 1.0

        splineX = new Spline(t, x);
        splineY = new Spline(t, y);
    }

    /**
     * @param t 0 <= t <= 1
     */
    public double[] getPoint(double t) {
        double[] result = new double[2];
        result[0] = splineX.getValue(t);
        result[1] = splineY.getValue(t);

        return result;
    }

    /**
     * @param t 0 <= t <= 1
     */
    public Point2d getPoint2d(double t) {
        return new Point2d(getPoint(t));
    }

    /**
     * @param t 0 <= t <= 1
     */
    public double[] getPointFast(double t) {
        double[] result = new double[2];
        result[0] = splineX.getFastValue(t);
        result[1] = splineY.getFastValue(t);

        return result;
    }

    /**
     * @param t 0 <= t <= 1
     */
    public Point2d getPoint2dFast(double t) {
        return new Point2d(getPointFast(t));
    }

    /**
     * Get all points from spline
     *
     * @param step
     */
    public List<Point2d> getAllpoints(double step) {
        List<Point2d> points = new ArrayList<>();
        for (double i = 0; i <= 1; i += step) {
            i = Math.round(i * 1000) / 1000d;
            points.add(getPoint2dFast(i));
        }
        return points;
    }

    public List<Point2d> getAllpoints(int count) {
        return getAllpoints(1.0 / (double) count);
    }

    public double[] getCurvatures(double step) {
        double[] curvatures = new double[(int) (1 / step) + 1];
        int j = 0;
        for (double i = 0; i <= 1; i += step) {
            i = Math.round(i * 10000) / 10000d;
            curvatures[j] = getCurvature(i);
            j++;
        }
        return curvatures;
    }
    
    public double[] getFirstDerivativeX(double step) {
        double[] derivatives = new double[(int) (1 / step) + 1];
        int j = 0;

        for (double i = 0; i <= 1; i += step) {
            i = Math.round(i * 10000) / 10000d;
            derivatives[j] = getDx(i);
            j++;
        }
        return derivatives;
    }

    public double[] getFirstDerivativeY(double step) {
        double[] derivatives = new double[(int) (1 / step) + 1];
        int j = 0;

        for (double i = 0; i <= 1; i += step) {
            i = Math.round(i * 10000) / 10000d;
            derivatives[j] = getDy(i);
            j++;
        }
        return derivatives;
    }    
    
    public double[] getSecondDerivativeY(double step) {
        double[] derivatives = new double[(int) (1 / step) + 1];
        int j = 0;

        for (double i = 0; i <= 1; i += step) {
            i = Math.round(i * 10000) / 10000d;
            derivatives[j] = getDyy(i);
            j++;
        }
        return derivatives;        
    }
    
    public double[] getSecondDerivativeX(double step) {
        double[] derivatives = new double[(int) (1 / step) + 1];
        int j = 0;

        for (double i = 0; i <= 1; i += step) {
            i = Math.round(i * 10000) / 10000d;
            derivatives[j] = getDxx(i);
            j++;
        }
        return derivatives;        
    }    
    
    /**
     * Used to check the correctness of this spline
     */
    public boolean checkValues() {
        return (splineX.checkValues() && splineY.checkValues());
    }

    public double getDx(double t) {
        return splineX.getDx(t);
    }

    public double getDy(double t) {
        return splineY.getDx(t);
    }

    public double getDxx(double t) {
        return splineX.getDxx(t);
    }

    public double getDyy(double t) {
        return splineY.getDxx(t);
    }

    public double getCurvature(double t) {
        if (t == 0.0 || t == 1.0) {
            return 0.0;
        } else {
            return /*Math.abs(*/ (getDx(t) * getDyy(t) - getDy(t) * getDxx(t)) / // x(t)' * y(t)" - y(t)' * x(t)" /
                    Math.pow((Math.pow(getDx(t), 2) + Math.pow(getDy(t), 2)), 1.5f);  // ( x(t)^2 + y(t)^2 )^3/2
        }
    }

    public Spline getSplineX() {
        return splineX;
    }

    public Spline getSplineY() {
        return splineY;
    }

    public double getLength() {
        return length;
    }

}

/* This code is PUBLIC DOMAIN */
/**
 * Interpolates given values by B-Splines.
 *
 * @author krueger
 */
class Spline {

    private double[] xx;
    private double[] yy;

    private double[] a;
    private double[] b;
    private double[] c;
    private double[] d;

    /**
     * tracks the last index found since that is mostly commonly the next one
     * used
     */
    private int storageIndex = 0;

    /**
     * Creates a new Spline.
     *
     * @param xx
     * @param yy
     */
    public Spline(double[] xx, double[] yy) {
        setValues(xx, yy);
    }

    /**
     * Set values for this Spline.
     *
     * @param xx
     * @param yy
     */
    public void setValues(double[] xx, double[] yy) {
        this.xx = xx;
        this.yy = yy;
        if (xx.length > 1) {
            calculateCoefficients();
        }
    }

    /**
     * Returns an interpolated value.
     *
     * @param x
     * @return the interpolated value
     */
    public double getValue(double x) {
        if (xx.length == 0) {
            return Double.NaN;
        }

        if (xx.length == 1) {
            if (xx[0] == x) {
                return yy[0];
            } else {
                return Double.NaN;
            }
        }

        int index = Arrays.binarySearch(xx, x);
        if (index > 0) {
            return yy[index];
        }

        index = -(index + 1) - 1;
        //TODO linear interpolation or extrapolation
        if (index < 0) {
            return yy[0];
        }

        return a[index]
                + b[index] * (x - xx[index])
                + c[index] * Math.pow(x - xx[index], 2)
                + d[index] * Math.pow(x - xx[index], 3);
    }

    /**
     * Returns an interpolated value. To be used when a long sequence of values
     * are required in order, but ensure checkValues() is called beforehand to
     * ensure the boundary checks from getValue() are made
     *
     * @param x
     * @return the interpolated value
     */
    public double getFastValue(double x) {
        // Fast check to see if previous index is still valid
        if (storageIndex > -1 && storageIndex < xx.length - 1 && x > xx[storageIndex] && x < xx[storageIndex + 1]) {

        } else {
            int index = Arrays.binarySearch(xx, x);
            if (index > 0) {
                return yy[index];
            }
            index = -(index + 1) - 1;
            storageIndex = index;
        }

        //TODO linear interpolation or extrapolation
        if (storageIndex < 0) {
            return yy[0];
        }
        double value = x - xx[storageIndex];
        return a[storageIndex]
                + b[storageIndex] * value
                + c[storageIndex] * (value * value)
                + d[storageIndex] * (value * value * value);
    }

    /**
     * Used to check the correctness of this spline
     */
    public boolean checkValues() {
        if (xx.length < 2) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the first derivation at x.
     *
     * @param x
     * @return the first derivation at x
     */
    public double getDx(double x) {
        if (xx.length == 0 || xx.length == 1) {
            return 0;
        }

        int index = Arrays.binarySearch(xx, x);
        if (index < 0) {
            index = -(index + 1) - 1;
        }

        return b[index] + 2 * c[index] * (x - xx[index]) + 3 * d[index] * Math.pow(x - xx[index], 2);
    }

    /**
     * Returns the second derivation at x.
     *
     * @param x
     * @return the second derivation at x
     */
    public double getDxx(double x) {
        if (xx.length == 0 || xx.length == 1) {
            return 0;
        }

        int index = Arrays.binarySearch(xx, x);
        if (index < 0) {
            index = -(index + 1) - 1;
        }

        return 2 * c[index] + 6 * d[index] * (x - xx[index]);
    }

//    @Override
//    public double derivative(final double x) {
//        final int j = locate(x);
//        final double dx = x - vx_[j];
//        return va_[j] + (2.0 * vb_[j] + 3.0 * vc_[j] * dx) * dx;
//    }
//
//    @Override
//    public double secondDerivative(final double val) {
//        final int j = locate(val);
//        final double dx = val - vx_[j];
//        return 2.0 * vb_[j] + 6.0 * vc_[j] * dx;
//    }
    /**
     * Calculates the Spline coefficients.
     */
    private void calculateCoefficients() {
        int N = yy.length;
        a = new double[N];
        b = new double[N];
        c = new double[N];
        d = new double[N];

        if (N == 2) {
            a[0] = yy[0];
            b[0] = yy[1] - yy[0];
            return;
        }

        double[] h = new double[N - 1];
        for (int i = 0; i < N - 1; i++) {
            a[i] = yy[i];
            h[i] = xx[i + 1] - xx[i];
            // h[i] is used for division later, avoid a NaN
            if (h[i] == 0.0) {
                h[i] = 0.01;
            }
        }
        a[N - 1] = yy[N - 1];

        double[][] A = new double[N - 2][N - 2];
        double[] y = new double[N - 2];
        for (int i = 0; i < N - 2; i++) {
            y[i] = 3 * ((yy[i + 2] - yy[i + 1]) / h[i + 1]
                    - (yy[i + 1] - yy[i]) / h[i]);

            A[i][i] = 2 * (h[i] + h[i + 1]);

            if (i > 0) {
                A[i][i - 1] = h[i];
            }

            if (i < N - 3) {
                A[i][i + 1] = h[i + 1];
            }
        }
        solve(A, y);

        for (int i = 0; i < N - 2; i++) {
            c[i + 1] = y[i];
            b[i] = (a[i + 1] - a[i]) / h[i] - (2 * c[i] + c[i + 1]) / 3 * h[i];
            d[i] = (c[i + 1] - c[i]) / (3 * h[i]);
        }
        b[N - 2]
                = (a[N - 1] - a[N - 2]) / h[N
                - 2]
                - (2 * c[N - 2] + c[N - 1]) / 3 * h[N
                - 2];
        d[N - 2] = (c[N - 1] - c[N - 2]) / (3 * h[N - 2]);
    }

    /**
     * Solves Ax=b and stores the solution in b.
     */
    public void solve(double[][] A, double[] b) {
        int n = b.length;
        for (int i = 1; i < n; i++) {
            A[i][i - 1] = A[i][i - 1] / A[i - 1][i - 1];
            A[i][i] = A[i][i] - A[i - 1][i] * A[i][i - 1];
            b[i] = b[i] - A[i][i - 1] * b[i - 1];
        }

        b[n - 1] = b[n - 1] / A[n - 1][n - 1];
        for (int i = b.length - 2; i >= 0; i--) {
            b[i] = (b[i] - A[i][i + 1] * b[i + 1]) / A[i][i];
        }
    }
}
