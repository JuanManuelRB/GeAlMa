import juanmanuel.gealma.Blade;

void main() {
    Blade num = new Blade(5 , 1, 0, 0);
    System.out.println(num);
    System.out.println(num.positiveBasis());
    System.out.println(num.times(num));
    System.out.println(num.times(new Blade(2)));
    System.out.println(num.times(new Blade(3, 2, 0, 0)));

    var neg = new Blade(2, 0, 1, 0);
    System.out.println(neg.times(neg));

    var z1 = new Blade(3, 0, 0, 1);
    var z2 = new Blade(3, 0, 0, 3);

    System.out.println(z1.times(z2));

    System.out.println();
    System.out.println(new Blade(2, 0b0, 0b10, 0).times(new Blade(1, 0, 0b11, 0)));
    System.out.println(new Blade(2, 0b0, 0b1, 0).times(new Blade(1, 0, 0b11, 0)));
    System.out.println(new Blade(2, 0b10, 0b0, 0).times(new Blade(1, 0b11, 0b0, 0)));
    System.out.println(new Blade(2, 0b1, 0b0, 0).times(new Blade(1, 0b11, 0b0, 0)));
}
