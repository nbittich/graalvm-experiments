fn main() {
    let mut list = vec![];
    for i in 0..70_000_000 {
        let v = X{v: format!("Hello {i}")};
        list.push(v);
    }

    println!("len: {}", list.len());
}

struct X {
    v: String
}