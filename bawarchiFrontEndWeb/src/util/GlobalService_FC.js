import axios from "axios";

const serverURL = `http://192.168.64.3:9190/`;

const hitPostService = async (props) => {
  const url = serverURL + props.childURL;

  console.log(url);

  const header = props.header;

  const response = await axios.post(url, props.postData, header);
  console.log(response);

  return response;
};

const hitGetService = async (props) => {
  const url = serverURL + props.childURL;

  const header = props.header;

  console.log("URL Hitting in GlobalServiceHandler in Get Service Call");
  console.log(url);

  const response = await axios.get(url, header);

  console.log("Data recieved");
  console.log(response);

  return response;
};

const hitPutService = async (props) => {
  const url = serverURL + props.childURL;

  console.log(url);

  const header = props.header;

  const response = await axios.put(url, props.postData, header);
  console.log(response);

  return response;
};

const hitDeleteService = async (props) => {
  const url = serverURL + props.childURL;

  const header = props.header;

  console.log("URL Hitting in GlobalServiceHandler in Get Service Call");
  console.log(url);

  const response = await axios.delete(url, header);

  console.log("Data recieved");
  console.log(response);

  return response;
};

const GlobalService = {
  hitPostService,
  hitGetService,
  hitDeleteService,
  hitPutService
};
export default GlobalService;
