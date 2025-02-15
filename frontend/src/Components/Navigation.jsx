import React from "react";
import { useContext } from "react";
import { DataContext } from "./Layouts/DataContext";
import { Link } from "react-router";

function Navigation() {
  const { sharedData, setSharedData } = useContext(DataContext);

  const clearUser = () => {
    setSharedData({})

  }

  return (
    <nav className="flex items-center  justify-between py-8 px-16">
      <div className="flex items-center gap-x-16">
        <p>Hello,{sharedData.username}</p>
      </div>
      <div className="flex items-center gap-x-16">
        <a className="font-semibold text-3xl">
          Online Booking
        </a>
      </div>
      <div className="flex items-center gap-x-8">
        <div>
          <Link to='/' onClick={clearUser}>switch</Link>
        </div>

      </div>
    </nav>
  );
}

export default Navigation;