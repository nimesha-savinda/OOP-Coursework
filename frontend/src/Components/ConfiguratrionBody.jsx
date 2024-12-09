import React, { useState } from "react";
import { createConfiguration } from "../Services/createConfiguration";

function ConfigurationBody() {
  const [configurationData, setConfigurationData] = useState({
    Total_number_of_tickets: "",
    Ticket_release_rate: "",
    Retrieval_rate: "",
    Maximum_Capacity: "",
  });
  const [errorMessage, setErrorMessage] = useState("");
  const [responseMessage, setResponseMessage] = useState("");

  const handleChange = (e) => {
    const { name, value } = e.target;
    setConfigurationData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setErrorMessage("");
    setResponseMessage("");

    try {
      const response = await createConfiguration(configurationData);
      setResponseMessage(response);
      console.log("Submitted Configuration Data:", configurationData);
    } catch (error) {
      setErrorMessage(error.toString());
    }
  };

  return (
    <div className="flex items-center justify-center h-screen">
      <div className="border-2 border-black p-6 rounded-lg flex flex-col items-center gap-6 w-80 -translate-y-16">
        <h2 className="text-2xl font-bold mb-4">Create Configuration</h2>
        <form onSubmit={handleSubmit} className="w-full flex flex-col gap-4">
          <input
            className="w-full border-2 border-black px-4 py-2 rounded"
            type="number"
            name="Total_number_of_tickets"
            value={configurationData.Total_number_of_tickets}
            onChange={handleChange}
            placeholder="Enter Total Tickets"
            required
          />
          <input
            className="w-full border-2 border-black px-4 py-2 rounded"
            type="number"
            name="Ticket_release_rate"
            value={configurationData.retrieval_rate}
            onChange={handleChange}
            placeholder="Enter Ticket Release Rate"
            required
          />
          <input
            className="w-full border-2 border-black px-4 py-2 rounded"
            type="number"
            name="Retrieval_rate"
            value={configurationData.m}
            onChange={handleChange}
            placeholder="Enter Customer Retrieval Rate"
            required
          />
          <input
            className="w-full border-2 border-black px-4 py-2 rounded"
            type="number"
            name="Maximum_Capacity"
            value={configurationData.maximum_capacity}
            onChange={handleChange}
            placeholder="Enter Maximum Capacity"
            required
          />
          <button
            type="submit"
            className="w-full border-2 border-black px-4 py-2 text-lg rounded-lg font-medium
              hover:bg-black hover:text-white transition"
          >
            Submit
          </button>
        </form>
        {responseMessage && <p className="text-green-500 text-sm">{responseMessage}</p>}
        {errorMessage && <p className="text-red-500 text-sm">{errorMessage}</p>}
      </div>
    </div>
  );
}

export default ConfigurationBody;
