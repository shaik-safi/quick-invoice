import Button from 'react-bootstrap/Button';
import Col from 'react-bootstrap/Col';
import Form from 'react-bootstrap/Form';
import Row from 'react-bootstrap/Row';

function InvoiceDetails() {
  return (
    <>
    <Form>
      <Form.Group  as={Col}  className="mb-3" controlId="formGridInvoiceNumber">
        <Form.Label>Product Name</Form.Label>
        <Form.Control placeholder="Enter Product Name" />
      </Form.Group>
      <Form.Group  as={Col}  className="mb-3" controlId="formGridInvoiceNumber">
        <Form.Label>Product Description</Form.Label>
        <Form.Control placeholder="Enter Product Description" />
      </Form.Group>
      <Row className="mb-3">
      <Form.Group  as={Col}  className="mb-3" controlId="formGridInvoiceNumber">
        <Form.Label>Unit Price</Form.Label>
        <Form.Control placeholder="Enter Unit Price" />
      </Form.Group>
      <Form.Group  as={Col}  className="mb-3" controlId="formGridInvoiceNumber">
        <Form.Label>Quantity</Form.Label>
        <Form.Control placeholder="Enter Quantity" />
      </Form.Group>
      </Row>
    </Form>
    </>
  );
}

export default InvoiceDetails;