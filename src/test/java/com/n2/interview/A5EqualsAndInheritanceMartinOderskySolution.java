package com.n2.interview;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Equals and inheritance - uneasy relationship. According to Joshua Bloch "there is no way to
 * extend an instantiable class and add a value component while preserving the equals contract"
 * (page 38, Effective Java, item 8). Joshua Bloch suggest as only way to use Composition over
 * Inheritance. But what if you have to stick Inheritance?
 * <p>
 * SOLUTION from Martin Odersky (author of Scala) See see:
 * http://www.artima.com/lejava/articles/equality.html Add extra method canEquals() which is called
 * on the other object when comparing making both sides mutually agree on minimal subclass
 * requirements.
 * <p>
 * Restricted mixed type equals() - in this case we genuinely assume here that ColorPoint of any
 * color is not equal intrinsicly colorless Point even if they have got the same coordinates.
 * However any class extending Point but not adding value component should be equal having the same
 * coordinates. In that sense it is Liskov Substitution Principle compliant.
 */
public class A5EqualsAndInheritanceMartinOderskySolution {

    @Test
    public void testEqualsSymmetryContractWithMixedTypes() {
        Point p = new Point(2, 3);
        ColorPoint cp = new ColorPoint(2, 3, 0);
        assertTrue("Broken symmetry", p.equals(cp) == cp.equals(p));
    }

    @Test
    public void testEqualsAndLiskovSubstitutionPrinciple() {
        ColorPoint cp = new ColorPoint(2, 3, 0);
        ColorPointDecorator cpd = new ColorPointDecorator(2, 3, 0);
        assertTrue("Broken substitution principle", cp.equals(cpd));
        assertTrue("Broken substitution principle", cpd.equals(cp));
    }

    @Test
    public void testEqualsForPoint() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(1, 1);
        assertTrue("Points with same x and y must be equal", p1.equals(p2));
        assertFalse("Points with different x or y must be not be equal", p1.equals(p3));
    }

    @Test
    public void testEqualsForColorPoint() {
        ColorPoint cp1 = new ColorPoint(2, 3, 1);
        ColorPoint cp2 = new ColorPoint(2, 3, 1);
        ColorPoint cp3 = new ColorPoint(1, 1, 0);
        assertTrue("Color points with same x,y and color must be equal", cp1.equals(cp2));
        assertFalse("Color points with different x,y or color must be not be equal", cp1.equals(cp3));
        assertFalse("Color points with different x,y or color must be not be equal",
                cp1.equals(new ColorPoint(2, 3, 10)));
        assertFalse("Color points with different x,y or color must be not be equal",
                cp1.equals(new ColorPoint(10, 3, 1)));
    }

    @Test
    public void testReflexivityEqualsContract() {
        Point p = new Point(2, 3);
        ColorPoint cp = new ColorPoint(2, 3, 0);
        assertTrue("Broken reflexivity", cp.equals(cp));
        assertTrue("Broken reflexivity", p.equals(p));
    }

    @Test
    public void testMixedTypesWithAddedFieldsCannotEqual() {
        Point p = new Point(2, 3);
        ColorPoint cp = new ColorPoint(2, 3, 0);
        assertFalse("Mixed types with added fields cannot equal", p.equals(cp));
        assertFalse("Mixed types with added fields cannot equal", cp.equals(p));
        // Why this is not a Liskov Substitution Principle breach?
        // we genuinely assume here that blue ColorPoint is not equal colorless Point even if they
        // have got the same coordinates.
    }

    @Test
    public void testNullEqualsContract() {
        Point p = new Point(2, 3);
        ColorPoint cp = new ColorPoint(2, 3, 0);
        assertFalse("Broken null contract, equals(null) must return false", p.equals(null));
        assertFalse("Broken null contract, equals(null) must return false", cp.equals(null));
    }

    //
    // For demonstration purposes implementations of Point and ColorPoint are included in test class
    //

    private static class Point {
        private final int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        protected boolean canEqual(Object other) {
            return (other instanceof Point);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other)
                return true;
            if (!(other instanceof Point))
                return false;
            Point otherPoint = (Point) other;
            if (!otherPoint.canEqual(this)) // extra subclassing check
                return false;
            if (x != otherPoint.x || y != otherPoint.y) // check fields
                return false;
            return true;
        }
        // hashCode() was removed for brevity
    }

    private static class ColorPoint extends Point {
        private final int color;

        public ColorPoint(int x, int y, int color) {
            super(x, y);
            this.color = color;
        }

        protected boolean canEqual(Object other) {
            return (other instanceof ColorPoint);
        }

        @Override
        public boolean equals(Object other) {
            if (this == other)
                return true;
            if (!(other instanceof ColorPoint))
                return false;
            ColorPoint otherColorPoint = (ColorPoint) other;
            if (!otherColorPoint.canEqual(this)) // extra subclassing check
                return false;
            if (color != otherColorPoint.color) // check fields
                return false;
            if (!super.equals(other)) // check superclass fields
                return false;
            return true;
        }
        // hashCode() was removed for brevity
    }

    private static class ColorPointDecorator extends ColorPoint {
        // extending classes without any "value components"
        // can simply inherit equals() and canEqauls()

        public ColorPointDecorator(int x, int y, int color) {
            super(x, y, color);
        }
        // methods adding functionality removed for brevity
    }
}