package me.listed.turok.values;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TurokDouble {
   private TurokString name;
   private TurokString tag;
   private double value;
   private double max;
   private double min;

   public TurokDouble(TurokString name, TurokString tag, double _double, double min, double max) {
      this.name = name;
      this.tag = tag;
      this.value = _double;
      this.max = max;
      this.min = min;
   }

   public void set_value(double _double) {
      this.value = _double;
   }

   public void set_slider_value(double _double) {
      if (_double >= this.max) {
         this.value = this.max;
      } else if (_double <= this.min) {
         this.value = this.min;
      } else {
         this.value = _double;
      }

   }

   public TurokString get_name() {
      return this.name;
   }

   public TurokString get_tag() {
      return this.tag;
   }

   public double get_value() {
      return this.value;
   }

   public static double round(double abs_1) {
      BigDecimal decimal = new BigDecimal(abs_1);
      decimal = decimal.setScale(2, RoundingMode.HALF_UP);
      return decimal.doubleValue();
   }

   public static double floor(double abs_1, double abs_2) {
      abs_1 = Math.floor(abs_1);
      abs_2 = Math.floor(abs_2);
      return abs_1 != 0.0D && abs_2 != 0.0D ? floor(abs_1, abs_1 % abs_2) : abs_1 + abs_2;
   }

   public static double step(double abs_1, double abs_2) {
      double floor_requested = floor(abs_1, abs_2);
      if (floor_requested > abs_2) {
         floor_requested = abs_2 / 20.0D;
      }

      if (abs_2 > 10.0D) {
         floor_requested = (double)Math.round(floor_requested);
      }

      if (floor_requested == 0.0D) {
         floor_requested = abs_2;
      }

      return floor_requested;
   }
}
