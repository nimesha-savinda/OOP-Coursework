function Navigation(props) {

  return (
    <nav className="flex items-center  justify-between py-8 px-16">
      <div className="flex items-center gap-x-16">
      <p>Hi, {props.name}</p>
      </div>
      <div className="flex items-center gap-x-16">
        <a className="font-semibold text-3xl" to="/">
          Online Booking
        </a>
      </div>
      <div className="flex items-center gap-x-8">
        <div>
          <button>Log out</button>
        </div>
        
      </div>
    </nav>
  );
}

export default Navigation;


const props = {
    name: "Manupa",
}