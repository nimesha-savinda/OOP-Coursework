import React from 'react';
import { Link } from 'react-router';

function RoleSelect() {
  return (
    <div className="flex items-center justify-center h-screen">
      <div
        className="border-2 border-black p-6 rounded-lg flex flex-col items-center gap-4 w-80 -translate-y-16"
      >
        <Link  className="w-full " to="/login">
        <button
          className="w-full border-2 border-black px-4 py-2 text-lg 
          rounded-lg font-medium hover:bg-black hover:text-white transition"
        >
          Customer
        </button></Link>
        <Link  className="w-full " to="/login">
        <button
          className="w-full border-2 border-black px-4 py-2 text-lg 
          rounded-lg font-medium hover:bg-black hover:text-white transition"
        >
          Vendor
        </button></Link>
      </div>
    </div>
  );
}

export default RoleSelect;
