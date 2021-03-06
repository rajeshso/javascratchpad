package com.n2.interview;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;



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
        assertTrue( p.equals(cp) == cp.equals(p), "Broken symmetry");
    }

    @Test
    public void testEqualsAndLiskovSubstitutionPrinciple() {
        ColorPoint cp = new ColorPoint(2, 3, 0);
        ColorPointDecorator cpd = new ColorPointDecorator(2, 3, 0);
        assertTrue( cp.equals(cpd),"Broken substitution principle");
        assertTrue( cpd.equals(cp), "Broken substitution principle");
    }

    @Test
    public void testEqualsForPoint() {
        Point p1 = new Point(2, 3);
        Point p2 = new Point(2, 3);
        Point p3 = new Point(1, 1);
        assertTrue(p1.equals(p2),"Points with same x and y must be equal");
        assertFalse(p1.equals(p3),"Points with different x or y must be not be equal");
    }

    @Test
    public void testEqualsForColorPoint() {
        ColorPoint cp1 = new ColorPoint(2, 3, 1);
        ColorPoint cp2 = new ColorPoint(2, 3, 1);
        ColorPoint cp3 = new ColorPoint(1, 1, 0);
        assertTrue( cp1.equals(cp2), "Color points with same x,y and color must be equal");
        assertFalse( cp1.equals(cp3), "Color points with different x,y or color must be not be equal");
        assertFalse(
                cp1.equals(new ColorPoint(2, 3, 10)), "Color points with different x,y or color must be not be equal");
        assertFalse(
                cp1.equals(new ColorPoint(10, 3, 1)), "Color points with different x,y or color must be not be equal");
    }

    @Test
    public void testReflexivityEqualsContract() {
        Point p = new Point(2, 3);
        ColorPoint cp = new ColorPoint(2, 3, 0);
        assertTrue(cp.equals(cp), "Broken reflexivity");
        assertTrue( p.equals(p), "Broken reflexivity");
    }

    @Test
    public void testMixedTypesWithAddedFieldsCannotEqual() {
        Point p = new Point(2, 3);
        ColorPoint cp = new ColorPoint(2, 3, 0);
        assertFalse( p.equals(cp), "Mixed types with added fields cannot equal");
        assertFalse( cp.equals(p), "Mixed types with added fields cannot equal");
        // Why this is not a Liskov Substitution Principle breach?
        // we genuinely assume here that blue ColorPoint is not equal colorless Point even if they
        // have got the same coordinates.
    }

    @Test
    public void testNullEqualsContract() {
        Point p = new Point(2, 3);
        ColorPoint cp = new ColorPoint(2, 3, 0);
        assertFalse( p.equals(null), "Broken null contract, equals(null) must return false");
        assertFalse( cp.equals(null), "Broken null contract, equals(null) must return false");
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